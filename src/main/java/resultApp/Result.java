package resultApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {

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

    @Override
    public String toString() {
        return "{" +
                "result=" + result +
                '}';
    }
}
