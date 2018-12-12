package top.izeroto.spring.bean;

public class TestBean {

    private String name = "testBean";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

	@Override
	public String toString() {
    	super.toString();
    	String s = "name="+name;
		System.out.println(s);
		return s;
	}
}
