package kodlamaio.nortwind.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name="business_position")
public class BusinessPosition {

    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="position_name")
    private String positionName;

    public BusinessPosition(){}

    public BusinessPosition(int id, String positionName){
        super();
        this.id = id;
        this.positionName = positionName;
    }

    public int getId(){
        return  this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getPositionName(){
        return this.positionName;
    }

    public void setPositionName(String positionName){
        this.positionName = positionName;
    }



}
