package br.com.contmatic.utilidades;

import java.util.List;
import java.util.Map;

public class ClasseTeste {

	private String string1;
	
	private String string2;
	
	private String string3;
	
	private TipoEnum tipoEnum;
	
	private AnotherClass anotherClass;
	
	private List<Class<String>> classes;
	
	private Map<Map<List<Class<?>>,Integer>,AnotherClass> porraLoca;

	public ClasseTeste() {
	}
	
	
	public List<Class<String>> getClasses() {
		return classes;
	}


	public void setClasses(List<Class<String>> classes) {
		this.classes = classes;
	}


	public Map<Map<List<Class<?>>, Integer>, AnotherClass> getPorraLoca() {
		return porraLoca;
	}


	public void setPorraLoca(Map<Map<List<Class<?>>, Integer>, AnotherClass> porraLoca) {
		this.porraLoca = porraLoca;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public TipoEnum getTipoEnum() {
		return tipoEnum;
	}

	public void setTipoEnum(TipoEnum tipoEnum) {
		this.tipoEnum = tipoEnum;
	}

	public AnotherClass getAnotherClass() {
		return anotherClass;
	}

	public void setAnotherClass(AnotherClass anotherClass) {
		this.anotherClass = anotherClass;
	}
	
	public static void main(String[] args) {
		System.out.println(Verificadores.verificaEncapsulamentos(ClasseTeste.class));
	}

}
