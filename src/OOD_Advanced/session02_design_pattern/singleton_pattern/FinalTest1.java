package OOD_Advanced.session02_design_pattern.singleton_pattern;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.singletonPattern
//ClassName: FinalTest1
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 20:00
public class FinalTest1 {
	
	//-----------------成员变量------------------//
	//初始化方式一，在定义变量时直接赋值
	private final int i = 3;
	
	//初始化方式二,声明完变量后在构造方法中为其赋值
	//如果采用用这种方式，那么每个构造方法中都要有j赋值的语句
	private final int j;
	
	public FinalTest1() {
		j = 3;
	}
	
	//如果取消该构造方法的注释，程序就会报错，因此它没有为j赋值
    /*public FinalTest1(String str) {

    }*/
	
	//为了方便我们可以这样写
	public FinalTest1(String str) {
		this();
	}
	
	//下面的代码同样会报错，因为对j重复赋值
    /*public FinalTest1(String str1, String str2) {
        this();
        j = 3;//The final field j may already have been assigned
    }*/
	
	//初始化方式三，声明完变量后在构造代码块中为其赋值
	//如果采用此方式，就不能在构造方法中再次为其赋值
	//构造代码块中的代码会在构造函数之前执行，如果在构造函数中再次赋值，
	//就会造成final变量的重复赋值
	private final int k;
	
	{
		k = 4;
	}
	
	//-----------------类变量（静态变量）------------------//
	//初始化方式一，在定义类变量时直接赋值
	public final static int p = 3;
	
	//初始化方式二，在静态代码块中赋值
	//成员变量可以在构造函数中赋值，但是类变量却不可以。
	//因此成员变量属于对象独有，每个对象创建时只会调用一次构造函数，
	//因此可以保证该成员变量只被初始化一次；
	//而类变量是该类的所有对象共有，每个对象创建时都会对该变量赋值
	//这样就会造成变量的重复赋值。
	public final static int q;
	
	static {
		q = 3;
	}
}
