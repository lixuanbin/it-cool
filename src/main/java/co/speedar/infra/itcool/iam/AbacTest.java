package co.speedar.infra.itcool.iam;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.io.IOUtils;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.main.SyncedEnforcer;
import org.casbin.jcasbin.model.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

public class AbacTest {
	public static void main(String[] args) throws IOException {
		AbacTest a = new AbacTest();
		Enforcer enforcer = a.buildAbacEnforcer(a.buildAbacModel("abac_rule_model.conf"));
		// TestResource data1 = new TestResource("data1", "alice");
		// TestResource data2 = new TestResource("data2", "bob");
		enforcer.addPolicy("r.sub.age > 18 && r.sub.age < 65", "r.obj.owner == r.sub.name", "*");
		// enforcer.addPolicy("r.sub.age < 60 && r.sub.name == \"bob\"", "/data2", "write");
		TestEvalRule alice = new TestEvalRule("alice", 18);
		TestResource data1 = new TestResource("data1", "bob");
		System.out.println(enforcer.enforce(alice, data1, "read"));
		System.out.println(enforcer.enforce(alice, data1, "write"));
		alice.setAge(19);
		System.out.println(enforcer.enforce(alice, data1, "read"));
		alice.setName("bob");
		System.out.println(enforcer.enforce(alice, data1, "read"));
		System.out.println(enforcer.enforce(alice, data1, "write"));
	}

	private Model buildAbacModel(String path) throws IOException {
		Model model = new Model();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
		String modelText = IOUtils.toString(inputStream, "utf-8");
		IOUtils.closeQuietly(inputStream);
		model.loadModelFromText(modelText);
		return model;
	}

	private Enforcer buildAbacEnforcer(Model model) {
		Enforcer e = new SyncedEnforcer(model);
		e.addFunction("myFunc", new AbstractFunction() {
			@Override
			public String getName() {
				return "myFunc";
			}

			@Override
			public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
				Object key1 = FunctionUtils.getJavaObject(arg1, env);
				Object key2 = FunctionUtils.getJavaObject(arg2, env);
				boolean result = key1.getClass().isInstance(key2) && Objects.deepEquals(key1, key2);
				return AviatorBoolean.valueOf(result);
			}
		});
		return e;
	}

	public static class TestEvalRule {
		private String name;
		private int age;

		TestEvalRule(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	public static class TestResource {
		String name;
		String owner;

		TestResource(String name, String owner) {
			this.name = name;
			this.owner = owner;
		}

		public String getName() {
			return name;
		}

		public String getOwner() {
			return owner;
		}
	}
}
