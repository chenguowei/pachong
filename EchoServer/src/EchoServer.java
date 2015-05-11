import java.net.*;
import java.io.*;


public class EchoServer {

	private int port = 8000;
	private ServerSocket serverSocket;
	
	public EchoServer() throws IOException{
		serverSocket = new ServerSocket(port);
		System.out.println("服务器启动！");
	}
	
	public String echo(String msg){
		return "echo:"+msg;
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut,true);
		
	}
	
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	
	public void service(){
		while(true){
			Socket socket = null;
			try{
				socket = serverSocket.accept();
				System.out.println("New connection accepted"+socket.getInetAddress()+":"+socket.getPort());
				BufferedReader br = getReader(socket);
				PrintWriter pw = getWriter(socket);
				
				String msg = null;
				while((msg = br.readLine()) != null){
					System.out.println(msg);
					pw.println(echo(msg));
					if(msg.equals("bye"))
						break;
				}
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			new EchoServer().service();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
