					在线聊天demo

Chat:新建一个Clinet,显示一个Frame窗口,窗口关不了；
Chat0.2:在frame窗口中添加一个TextArea 和一个TextField控件；
Chat0.3:给frame窗口添加监听事件 addWindowListener(),import java.awt.event.*;
Chat0.4:为TextField控件添加事件处理，把在TextField中的内容显示到TextArea中；
Chat0.5:新建一个Server；
Chat0.6:client端建立连接connect；
Chat0.7:client端向server端发送数据,只能发送一次；
Chat0.8:调整client代码 保证流OutputStream , 断开连接时再关闭流；客户端与服务器之间断开连接时会出现EOFException,因为客户端关闭，服务器端还一直阻塞时的readUTF();
Chat0.9:调整server端代码使关闭流更加严谨；
Chat1.0:连接多个客户端，在服务器端建立Client内部类，Client 是个线程类。每连接一个客户端就启动一个线程。此版本还只是客户端往服务器端发消息。
Chat1.1:服务器端把每个客户端发过来的消息，发送回给每个客户端。还没有验证
Chat1.2:客户端验证服务器端发过来的信息。


note:
	(1)导入文件/项目
	import->General->FileSystem
	import->General->Projects
	(2）自动调整格式
	 右键->sources->format
exception:
	（1）java.net.BindException:Address already in use:JVM_Bind
	（2）java.net.ConnectException: connnection refused:connect,服务器端没启动，客户端先启动了。
	（3）java.net.SocketException: Socket is closed,客户端与服务器之间断开连接时会出现EOFException,因为客户端关闭，客户端代码还一直阻塞的读取来自服务器的数据client:readUTF();
	（4）java.io.EOFException :客户端与服务器之间断开连接时会出现EOFException,因为客户端关闭，服务器端还一直阻塞的读取来自客户端的数据readUTF();
