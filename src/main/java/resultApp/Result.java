package resultApp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String result;

    public Result() {
    }

    public Result(Long id, String result){
        super();
        this.id = id;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "{" +
                "result=" + result +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream stream) 
        throws java.io.IOException{
            stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream)
        throws java.io.IOException, ClassNotFoundException{
            stream.defaultReadObject();
    }
    }
