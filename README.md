# Muti Thread là gì ?
Trong 1 chương trình nhưng có nhiều luồng độc lập sử lý song song với nhau
## Tại sao sử dụng ?
* Trong một số trường hợp cần sử dụng đa luồng để sử lý 1 số trường hợp ví dụ :
 * Trong các chương trình về multimedia đỏi hỏi nhiều về việc xử lý song song như yêu cầu về audio, video, thiết bị vào ra, điều khiển ...
 * Trong những hệ thống lớn về client/server việc dùng threads sẽ dẫn đến việc dễ thiết kế và quản lý.	
 * Trên các hệ thống multi-processor, máy ảo JVM có thể đặt nhiều luồng vào nhiều processor.
 
## how ?
* Mọi chương trình Java đề có ít nhất là một thread. Nó được tạo khi bạn gọi phương thức static main
![mo ph ng thread](https://cloud.githubusercontent.com/assets/18228937/17830219/e0429ac2-66ef-11e6-9e60-fa08d295c876.png)

* ### Còn 1 số cách tạo Thread
```
// ===============Khai báo Object tường minh================
		Runnable runable = new Runnable() {
			@Override
			public void run() {
				System.out.println("F");
			}
		};
		
		Thread thread = new Thread(runable);
		thread.start();
		
		//=========== Anonymod Innert type===========
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("D");
				
			}
		}).start();
		
		//================================================
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("D");
			}
		});
		thread1.start();
	}
```
### Vòng Đời Của Thread
![thread-life-cycle](https://cloud.githubusercontent.com/assets/18228937/17830303/1ed63c2e-66f2-11e6-8fe9-84de88094769.jpg)

1.	New: Luồng chưa được bắt đầu.
2.	Runnable: Luồng đang thực thi.
3.	Block: Luồng đang đợi để được phép truy nhập vào một tài nguyên mà đang được sử dụng bới một thread khác.
4.	Waiting: Luồng đang đợi một thread khác thực thi, có thể đợi vô hạn nếu không được các phương thức notify() hay notifyall()   gọi.
5.	Time waiting: Luông đang đợi trong một khoảng thời gian xác định cho thread khác tiếp tục thực thi.
6.	Terminated: Việc thực thi hoàn toàn kết thúc, không thể phục hồi lại được.

### Một số phương thức thao tác với Thread
+ Static int activeCount().
 * Trả về số lượng threads đang còn hoạt động trong nhóm luồng hiện tại.
+ String getName()
 * Trả về tên của luồng hiện tại
+ int getPriority() 
 * Trả về độ ưu tiên của luồng hiện tại
+ void join()
 * Đợi đến khi nào luồng hiện tại chết đi.
+ void setName(String name)
 * Thay đổi tên của luồng
+ void setPriority(int priority)
 * Thay đổi độ ưu tiên của luồng
+ void sleep(long millis)
 * Để luồng hiện tại “ngủ” trong 1 khoảng thời gian là millis
 
### Độ ưu tiên(Priority)
* Độ ưu tiên của luồng là mức độ ưu tiên về việc sử dụng tài nguyên của hệ thống tại cùng một thời điểm.
* Độ ưu tiên của một luồng __mặc định là 5__. Có giá trị từ MIN_PRIORITY = 1 đến MAX_PRIORITY = 10. 
* có độ ưu tiên cao nhất nên sẽ dành được mức độ ưu tiên về việc sử dụng tài nguyên của hệ thống nhất.

# Anonymous Inner Class 
 Inner Class được khai báo mà không kèm theo tên lớp được gọi là Anonymous Inner Class.
 ## Tại sao phải sử dụng nó ?
![anonymod class va class](https://cloud.githubusercontent.com/assets/18228937/17830626/1b14bf3a-66fb-11e6-88ef-63299d37bf49.png)

* tùy vào mục đích sử dụng mô phỏng trên thì Anonymous Inner Class giúp tối ưu về mặt bộ nhớ .

### inner Class là gì ? 
là class trong class 

# Đồng bộ hóa (synchronized) 
Quản lý Nhiều thread khi dùng chung dữ liệu , thread này sử dụng thread kia chờ và ngược lại 
## Khi nào thì cần đến ? 
 



