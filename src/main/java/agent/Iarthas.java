package agent;

import java.io.IOException;
import java.io.Serializable;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

/**
 * Created by 64669 on 2019/7/12.
 */
public class Iarthas implements Serializable {

    public static void main(String[] args) throws Exception{
        timeTunnel("agent.Job.doAdd","57436");
    }


    public static void timeTunnel(String methodPath ,String pid)
        throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine virtualMachine = VirtualMachine.attach(pid);
        virtualMachine.loadAgent("F:\\\\iarthas\\\\target\\\\agentTest-1.0-SNAPSHOT.jar", methodPath);
        virtualMachine.detach();
    }

    public static void watch(String methodPath ,String pid)
        throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine virtualMachine = VirtualMachine.attach(pid);
        virtualMachine.loadAgent("C:\\\\Users\\\\64669\\\\Desktop\\\\arthas\\\\watch.jar", methodPath);
        virtualMachine.detach();
    }


    public static void trace(String methodPath ,String pid)
        throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine virtualMachine = VirtualMachine.attach(pid);
        virtualMachine.loadAgent("C:\\\\Users\\\\64669\\\\Desktop\\\\arthas\\\\trace.jar", methodPath);
        virtualMachine.detach();
    }

    public static void redefine(String classPath, String pid)
        throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine virtualMachine = VirtualMachine.attach(pid);
        virtualMachine.loadAgent("C:\\\\Users\\\\64669\\\\Desktop\\\\arthas\\\\redefine.jar", classPath);
        virtualMachine.detach();
    }
}
