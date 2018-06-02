package com.xinyue.hotupdate;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class HotUpdateMain {

	public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException,
			AgentInitializationException, InterruptedException {
		//这个pid在实际应用中可以通过args参数传进来
		String pid = "7580";
		//VirtualMachine是jdk中tool.jar里面的东西，所以要在pom.xml引用这个jar
		VirtualMachine vm = VirtualMachine.attach(pid);
		// 这个路径是相对于被热更的服务的，也就是这个pid的服务，也可以使用绝对路径。
		vm.loadAgent("config\\LoadAgent-0.0.1-SNAPSHOT.jar");
		// vm.detach();
		// Thread.sleep(300000);
	}
}
