package OOD_Advanced.session01_basic_concept.myImmurtable;
import com.google.common.collect.ImmutableList;
import java.util.List;

//Project: techbow
//Package: OOD_Advanced.session01_basic_concept
//ClassName: MyImmutable
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 11:28
public final class MyImmutable {
	private final int intVal;
	private final String str;
	private final boolean flag;
	private final ImmutableList<String> immutableList; //TODO
	
	MyImmutable(int intVal, String str, boolean flag, List<String> list) {
		this.intVal = intVal;
		this.str = str;
		this.flag = flag;
		this.immutableList = ImmutableList.copyOf(list);
	}
	
	public int getInt() {
		return this.intVal;
	}
	
	public String getStr() {
		return this.str;
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	public ImmutableList<String> getList() {
		return this.immutableList;
	}
}
