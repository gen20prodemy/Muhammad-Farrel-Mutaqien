package POJO;

public class Karyawan{
    private int id;
    private String departemen;
    private String nama;

    public Karyawan(int id, String nama, String departemen){
        this.id = id;
        this.departemen = departemen;
        this.nama = nama;
    }

    public void setNama(int id, String nama){
        this.id = id;
        this.nama = nama;
    }

    public void setDepartemen(int id, String departemen){
        this.id = id;
        this.departemen = departemen;
    }

    public String getNama(){
        return nama;
    }

    public  String getDepartemen(){
        return departemen;
    }


    public int getId(){
        return id;
    }
}
