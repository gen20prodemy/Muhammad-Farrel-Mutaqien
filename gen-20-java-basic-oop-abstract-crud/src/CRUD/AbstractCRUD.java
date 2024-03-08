package CRUD;

import java.util.HashMap;
import java.util.Map;

import Interface.Interface;
import POJO.DataTiket;

public abstract class AbstractCRUD implements Interface{
    protected Map<Integer, DataTiket> database;
    public AbstractCRUD(){
        this.database = new HashMap<>();
    }
    public abstract void tambahData(DataTiket data);
    public abstract void tampilkanData();
    public abstract void updateData(DataTiket data);
    public abstract void hapusData(DataTiket data);
    public abstract void cetakData();
    public abstract void bacaData();
}
