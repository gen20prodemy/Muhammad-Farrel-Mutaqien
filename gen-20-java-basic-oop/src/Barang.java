class Barang {
    protected String nama;
    protected float harga;

    public Barang (String nama, float harga){
        this.nama = nama;
        this.harga = harga;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setHarga(float harga){
        this.harga = harga;
    }

    public String getNama(){
        return nama;
    }

    public float getHarga(){
        return harga;
    }
}

class Makanan extends Barang{
    private int jumlah;
    public Makanan(String nama, float harga, int jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public void setHapus(){
        this.nama = null;
        this.harga = 0.0f;
        this.jumlah = 0;
    }

    public int getJumlah(){
        return jumlah;
    }

    public String toString(){
        return nama+"\t\t\t"+harga+"\t\t\t"+jumlah;
    }
}

class Minuman extends Barang{
    private int jumlah;
    public Minuman(String nama, float harga, int jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public void setHapus(){
        this.nama = null;
        this.harga = 0.0f;
        this.jumlah = 0;
    }

    public int getJumlah(){
        return jumlah;
    }

    public String toString(){
        return nama+"\t\t\t"+harga+"\t\t\t"+jumlah;
    }
}

class Obat extends Barang{
    private int jumlah;
    public Obat(String nama, float harga, int jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public void setHapus(){
        this.nama = null;
        this.harga = 0.0f;
        this.jumlah = 0;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public int getJumlah(){
        return jumlah;
    }

    public String toString(){
        return nama+"\t\t\t"+harga+"\t\t\t"+jumlah;
    }
}