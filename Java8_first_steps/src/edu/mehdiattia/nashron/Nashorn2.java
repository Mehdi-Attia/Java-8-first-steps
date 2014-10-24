package edu.mehdiattia.nashron;

import java.io.FileReader;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Calling java methods from javascript with nashorn.
 *
 * @author Mehdi Attia
 */
public class Nashorn2 {

	public static String fun(String name) {
		System.out.format("Hi there from Java, %s", name);
		return "greetings from java";
	}

	public static void fun2(Object object) {
		System.out.println(object.getClass());
	}

	public static void fun3(ScriptObjectMirror mirror) {
		System.out.println(mirror.getClassName() + ": " + Arrays.toString(mirror.getOwnKeys(true)));
	}

	public static void fun4(ScriptObjectMirror person) {
		System.out.println("Full Name is: " + person.callMember("getFullName"));
	}

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("res/nashorn2.js"));
	}

}