package gruppe3.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class SelectOneView {
     
    private String option;
    private int id;
  
    @PostConstruct // Ved ikke? https://www.primefaces.org/showcase/ui/input/listbox.xhtml
 
    public String getOption() {
    	String option = "" + id;
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
        id = Integer.parseInt(option);
       // setEducationId(Integer.parseInt(option));
    }
}
