package Thread;

import java.util.Random;

public class DongBoLuong {

	static Data datashare ;
	
	public static void main(String[] args) {
		datashare = new Data();
		
		datashare.setFlag(1);
		
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (datashare) {      // đặt synchronized để đánh dấu datashare được bảo vệ nhìn datashare mà làm việc
					for (int i = 0; i < 100 ;) {
						try {
							if(datashare.getFlag() == 1){
								int a = new Random().nextInt(100);
								datashare.setA(a);
								System.out.println("===============");
								System.out.println("i = "+ i);
								System.out.println("A=" +datashare.getA());
								Thread.sleep(8);
								i++;
								datashare.setFlag(2);    // trả lại cờ cho thread 2 sài
								datashare.notifyAll();  // đánh thức mấy thằng còn lại
							}else{
								datashare.wait();      // ko phải cờ của mình bắt nó chờ
							}
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// khi kết thúc thằng 1 bật cờ stop cho 2
					System.out.println("STOP Thread 1");
					datashare.setFlag(0);
					datashare.notifyAll();
				}
			}
		});
//		threadA.start();
		
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(datashare){
					for (; true; ) {
						try {
							if(datashare.getFlag() == 2 || datashare.getFlag() == 0){
								int a = new Random().nextInt(100);
								datashare.setB(a);
								System.out.println("B= " + datashare.getB());
								Thread.sleep(9);
								
								if(datashare.getFlag() == 0){
									datashare.setFlag(4);
									datashare.notifyAll(); 
									System.out.println("STOP Thread 2");
									 break;
								}
								datashare.setFlag(3);
								datashare.notifyAll();    // báo cho thread 3 thức dậy làm việc ở đây 3 làm việc
								
							}else{
								datashare.wait();
							}
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		});
//		threadB.start();
		
		Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (datashare) {
					for (;true;) {
						try {
							if(datashare.getFlag() == 3 || datashare.getFlag() == 4){
								System.out.println("Tong= " + datashare.tinhTong());
								Thread.sleep(10);
								
								if(datashare.getFlag() == 4){System.out.println("STOP Thread 3"); break;}
								
								datashare.setFlag(1);
								datashare.notifyAll();   // báo cho thread 1 làm việc 
								
							}else{
								datashare.wait();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}
		});
		
		threadA.start();
		threadB.start();
		threadC.start();
	}
}
