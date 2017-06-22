import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name){
		super(source);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
