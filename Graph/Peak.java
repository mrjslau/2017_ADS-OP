import java.util.ArrayList;

public class Peak {
	private String name;
	private ArrayList<String> borders = null;
	private ArrayList<Peak> refs = null;
	
	public Peak(String name){
		this.name = name;
	}
	public Peak(String name, ArrayList<String> borders){
		this.name = name;
		this.borders = borders;
		refs = new ArrayList<Peak>();
	}
	
	public void addRef(Peak peak){
		refs.add(peak);
	}
	
	public String getName(){
		return this.name;
	}
	public ArrayList<String> getBorders(){
		return this.borders;
	}
	public ArrayList<Peak> getRefs(){
		return this.refs;
	}
}
