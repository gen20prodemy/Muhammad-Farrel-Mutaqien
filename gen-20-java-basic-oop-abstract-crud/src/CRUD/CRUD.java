package CRUD;

import Interface.Interface;
import Validasi.InputException;
import POJO.DataTiket;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CRUD extends AbstractCRUD implements Interface{
    public CRUD(){
        this.database = new HashMap<>();
    }

    @Override
    public void tambahData(DataTiket data) {
        try {
            if(database.containsKey(data.getTicketID())){
                throw  new InputException("ID "+data.getTicketID()+" sudah terdaftar!!");
            }
            database.put(data.getTicketID(), data);
            System.out.println("Data berhasil dimasukan!");
        } catch (Exception e){
            System.out.println("Error!! "+e.getMessage());
        }
    }

    @Override
    public void tampilkanData() {
        System.out.println("==========================");
        System.out.println("NOMOR TIKET\t||\tNAMA");
        System.out.println("==========================");

        for(Map.Entry<Integer, DataTiket> entry: database.entrySet()){
            System.out.println("\t"+entry.getKey()+"\t\t\t"+entry.getValue().getName());
        }
    }

    @Override
    public void updateData(DataTiket data) {
        if(!database.containsKey(data.getTicketID())){
            System.out.println("Tiket "+data.getTicketID()+" tidak ada!!");
            return;
        }
        DataTiket update = database.get(data.getTicketID());
        update.setName(data.getName());
        System.out.println("Nama berhasil diubah di database!");
    }

    @Override
    public void hapusData(DataTiket data) {
        if(!database.containsKey(data.getTicketID())){
            System.out.println("Tiket "+data.getTicketID()+" tidak ada!!");
            return;
        }
        database.remove(data.getTicketID());
        System.out.println("Tiket berhasil di hapus!");
    }

    @Override
    public void cetakData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("FileTicket.txt"))){
            for(Map.Entry<Integer, DataTiket> entry: database.entrySet()){
                writer.write(entry.getKey()+"\t"+entry.getValue().getName()+"\n");
//                writer.newLine();
            }
            System.out.println("Data berhasil disimpan ke dalam file FileTicket.txt!");
        } catch (IOException e){
            System.out.println("Error !!"+ e.getMessage());
        }
    }
    @Override
    public void bacaData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("FileTicket.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int key = Integer.parseInt(parts[0].trim());
                String value = parts[1].trim();

                DataTiket data = new DataTiket(key,value);
                database.put(key, data);
            }
            System.out.println("Data berhasil dibaca dari file: FileTicket.txt");
        } catch (IOException e) {
            System.out.println("Error saat membaca file: " + e.getMessage());
        }
        return;
    }
}
