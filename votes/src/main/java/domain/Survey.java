package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Survey extends DomainEntity implements Serializable{
	
	private static final long serialVersionUID = 749544364605664829L;
	
	//Attributes
	private String title;
	private String description;
	private String category;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer census;
	
	//Constructors
	public Survey() {
		super();
		
		questions = new LinkedList<Question>();
	}
	
	public Survey(String title, String description, String category, LocalDate startDate,
			LocalDate endDate, Integer census) {
		super();
		
		checkFecha(startDate, endDate);
		
		this.title = title;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.census = census;
				
		
		questions = new LinkedList<Question>();
	}
	
	//Methods
	@NotBlank
	@Length(min=5, max=15, message="The field must be between 5 and 15 characters")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotBlank
	@Length(min=5, max=150, message="The field must be between 5 and 150 characters")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotBlank
	@Length(min=3, max=15, message="The field must be between 3 and 15 characters")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@DateTimeFormat(pattern="MM-dd-yyyy")
	public LocalDate getStartDate() {
				return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		if(endDate != null){
			checkFecha(startDate,endDate);
		}
		this.startDate = startDate;
	}
	@DateTimeFormat(pattern="MM-dd-yyyy")
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		if(startDate != null){
			checkFecha(startDate,endDate);
		}
		this.endDate = endDate;
	}
	
	public Integer getCensus() {
		return census;
	}

	public void setCensus(Integer census) {
		this.census = census;
	}

	//Relationships
	private Collection<Question>questions;
	private String usernameCreator;
	
	public String getUsernameCreator() {
		return usernameCreator;
	}

	public void setUsernameCreator(String usernameCreator) {
		this.usernameCreator = usernameCreator;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotEmpty
	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
	public void addQuestion(Question q){
		questions.add(q);
	}
	public void removeQuestion(Question q){
		questions.remove(q);
	}

	@Override
	public String toString() {
		return "Survey [title=" + title + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", census=" + census + ", questions=" + questions + "]";
	}
	
	private void checkFecha(LocalDate startDate, LocalDate endDate){
		
		if(startDate.isBefore(LocalDate.now())){
			throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a la actual");
		}
		
		if(endDate.isBefore(startDate)){
			throw new IllegalArgumentException("La fecha de fin no puede ir antes que la de inicio");
		}
			
		if(startDate.plusYears(2).isAfter(endDate)){
			throw new IllegalArgumentException("La votación no puede durar mas de 2 años");
			
		}
		
	}
	
	
	
}
