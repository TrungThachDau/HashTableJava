import com.sun.security.jgss.AuthorizationDataEntry;

import java.io.*;
import java.util.Scanner;

class DataItem// Khởi tạo 1 lớp chứa biến dữ liệu
{
    private int iData;// Dữ liệu
    public DataItem(int ii)//Biến chứa dữ liệu
    {
        iData = ii;
    }
    public int getKey()// Gọi ra dữ liệu của biến
    {
        return iData;
    }
}
//lớp bảng băm
class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    //Hàm khởi tạo
    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }
//Hàm hiển thị
    public void Display() {
        for(int i=0;i<arraySize;i++)
        {
            System.out.print("\n"+i+": ");
            if(hashArray[i]!=null)
                System.out.print(" "+hashArray[i].getKey());
        }
    }
// Hàm băm
    public int HashFunc(int key) {
        return key % arraySize;
    }
//Hàm Chèn
    public void Insert(DataItem item) {
        int key = item.getKey();
        int index = HashFunc(key);
        while(hashArray[index]!=null)
        {
            index = (index +1)%arraySize;
        }
        hashArray[index]= item;
    }
    //Hàm Xóa
    public DataItem Delete(int key)
    {
        int index = HashFunc(key);
        while(hashArray[index].getKey()!=key&&hashArray[index]!=null)
        {
            index = (index +1) % arraySize;
        }
        if(hashArray[index].getKey()==key)
        {
            DataItem temp = hashArray[index];
            hashArray[index]=nonItem;
            System.out.println("Da xoa xong");
            return temp;
        }
        else {
            {
                System.out.println("Khong tim thay");
            }
        }
        return null;
    }
    //Hàm tìm
    public DataItem Find(int key)
    {
        int index = HashFunc(key);
        while(hashArray[index].getKey()!=key&&hashArray[index]!=null)
        {
            index = (index +1) % arraySize;
        }
        if(hashArray[index].getKey()==key)
        {
            System.out.println("Tim thay "+key);
        }
        else {
            System.out.println("Khong tim thay"+ key);
        }
        return null;
    }
}
//Lớp có main
public class HashApp {
    //Hàm menu
    public static void menu()
    {
        System.out.println("\n1. Them phan tu");
        System.out.println("2. Xem bang bam");
        System.out.println("3. Them phan tu tu mang");
        System.out.println("4. Tim kiem phan tu");
        System.out.println("5. Xoa phan tu");

    }
//Hàm main
    public static void main(String[] args) {

        DataItem aDataItem;
        int aKey, size, n, keysPerCell,chucnang;
        int []a = { 1,3,4,5,8,12,13,24,21,9 };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap kich thuoc bang bam");
        size = scanner.nextInt();// Nhập kích thước bảng băm
        HashTable theHashTable = new HashTable(size);
        System.out.println("Khoi tao xong");
        do
        {
            menu();
            System.out.println("Chon chuc nang: ");
            chucnang=scanner.nextInt();
            switch (chucnang)
            {

                case 1 ->{
                    System.out.println("Nhap phan tu can them: ");
                    aKey=scanner.nextInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.Insert(aDataItem);
                }
                case 2 -> theHashTable.Display();
                case 3 ->{
                    n=10;
                    for(int i=0;i<n;i++)
                    {
                        aKey=a[i];
                        aDataItem=new DataItem(aKey);
                        theHashTable.Insert(aDataItem);
                    }
                }
                case 4->
                {
                    System.out.print("Nhap phan tu can tim: ");
                    aKey = scanner.nextInt();
                    aDataItem = theHashTable.Find(aKey);
                }
                case 5 ->
                        {
                            System.out.print("Nhap phan tu can xoa: ");
                            aKey = scanner.nextInt();
                            theHashTable.Delete(aKey);
                        }
            }

        }
        while(chucnang!=0);
    }

}
