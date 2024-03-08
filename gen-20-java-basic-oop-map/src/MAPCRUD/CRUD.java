package MAPCRUD;

import java.util.HashMap;
import java.util.Map;

import POJO.Karyawan;
import Exception.ValidasiInput;
import Interface.InterfaceCRUD;

public class CRUD implements InterfaceCRUD{
    private Map<Integer, Karyawan> database;

    public CRUD(){
        this.database = new HashMap<>();
    }

    @Override
    public void tambahData(Karyawan data){
        try {
            if(database.containsKey(data.getId())){
                throw  new ValidasiInput("ID "+data.getId()+" sudah terdaftar!!");
            }
            database.put(data.getId(), data);
            System.out.println("Data berhasil dimasukan!");
        } catch (Exception e){
            System.out.println("Error!! "+e.getMessage());
        }
    }

    public void tampilkanData(){
        System.out.println("==================================");
        System.out.println("ID\t||\tNama\t||\tDepartemen\t||");
        System.out.println("==================================");

        for(Map.Entry<Integer, Karyawan> entry: database.entrySet()){
            System.out.println(entry.getKey()+"\t\t"+entry.getValue().getNama()+"\t\t"+entry.getValue().getDepartemen());
        }
    }

    @Override
    public void updateNama(Karyawan data){
        if(!database.containsKey(data.getId())){
            System.out.println("ID "+data.getId()+" tidak ditemukan!!");
            return;
        }
        Karyawan updateNama = database.get(data.getId());
        updateNama.setNama(data.getId(), data.getNama());
        System.out.println("Data berhasil diubah!");
    }

    @Override
    public void updateDepartemen(Karyawan data){
        if(!database.containsKey(data.getId())){
            System.out.println("ID "+data.getId()+" tidak ditemukan!!");
            return;
        }
        Karyawan updateNama = database.get(data.getId());
        updateNama.setDepartemen(data.getId(), data.getDepartemen());
        System.out.println("Data berhasil diubah!");
    }

    @Override
    public void hapusData(Karyawan data) {
        if(!database.containsKey(data.getId())){
            System.out.println("ID "+data.getId()+" tidak ada!!");
            return;
        }
        database.remove(data.getId());
        System.out.println("Data berhasil di hapus!");
    }
}