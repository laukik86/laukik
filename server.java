import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {


    public static void main(String[] args) throws IOException {

        Socket socket =null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter=null;
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;


        serverSocket = new ServerSocket(12121);

        while (true){
            try {
                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);


                while (true){
                    String message = bufferedReader.readLine();

                    System.out.println("Client:"+ message);

                    bufferedWriter.write("Message recived");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();


                    if(message.equalsIgnoreCase("Bye")){
                        break;
                    }

                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedWriter.close();
                bufferedReader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}