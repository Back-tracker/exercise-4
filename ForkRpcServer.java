import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcServer;
import org.apache.xmlrpc.XmlRpcServerConfigImpl;

import java.io.*;

public class ForkRpcServer {
    public static class ForkHandler {
        // This method simulates the "fork" by executing a new process
        public String executeForkTask() throws IOException, InterruptedException {
            // Simulate creating a new process (similar to fork)
            ProcessBuilder processBuilder = new ProcessBuilder("echo", "Hello from the forked process!");
            Process process = processBuilder.start();

            // Capture the output of the child process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            output.append("Child process exited with code: ").append(exitCode);
            return output.toString();
        }
    }

    public static void main(String[] args) {
        try {
            // Create and configure the XML-RPC server
            WebServer server = new WebServer(8080); // Start the server on port 8080
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
            XmlRpcServerConfigImpl config = new XmlRpcServerConfigImpl();
            xmlRpcServer.setConfig(config);

            // Register the handler class to be invoked remotely
            xmlRpcServer.setHandlerMapping(new org.apache.xmlrpc.server.PropertyHandlerMapping());
            server.addHandler("ForkHandler", ForkHandler.class);

            // Start the server
            System.out.println("Starting XML-RPC Server...");
            server.start();
            System.out.println("XML-RPC Server is running at http://localhost:8080");
        } catch (Exception e) {
            System.out.println("Error starting the XML-RPC Server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
