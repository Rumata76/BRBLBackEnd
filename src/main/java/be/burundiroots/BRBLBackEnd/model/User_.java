package be.burundiroots.BRBLBackEnd.model;

import jakarta.persistence.*;

@Entity

public class User_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String email;
    private String password;
    private String genre;
    private String birthDate;
    private String placeOfBirth;
    private String fixPhone;
    private String mobilePhone;
    private String nationality;

    @ManyToMany
    @JoinTable(
            name = ""
    )

    @ManyToOne
    @JoinColumn(name = "idEvent")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "idCourse")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "idExtern")
    private Extern extern;

    @ManyToOne
    @JoinColumn(name = "idMeeting")
    private Meeting meeting;

    public Long getIdUser(){
        return idUser;
    }
    public void setIdUser(Long idUser){
        this.idUser = idUser;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public String getPlaceOfBirth(){
        return placeOfBirth;
    }
    public void setPlaceOfBirth(String placeOfBirth){
        this.placeOfBirth = placeOfBirth;
    }
    public String getFixPhone(){
        return fixPhone;
    }
    public void setFixPhone(String fixPhone){
        this.fixPhone = fixPhone;
    }
    public String getMobilePhone(){
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
    }
    public String getNationality(){
        return nationality;
    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public Event getEvent(){
        return event;
    }
    public void setEvent(Event event){
        this.event = event;
    }

    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }
    public Extern getExtern(){
        return extern;
    }
    public void setExtern(Extern extern){
        this.extern = extern;
    }
    public Meeting getmeeting(){
        return meeting;
    }
    public void setMeeting(Meeting meeting){
        this.meeting = meeting;
    }

}
