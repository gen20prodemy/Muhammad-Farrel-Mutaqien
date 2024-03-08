package Interface;

import POJO.Karyawan;

public interface InterfaceCRUD {
    void tambahData(Karyawan data);
    void tampilkanData();
    void updateNama(Karyawan data);
    void updateDepartemen(Karyawan data);
    void hapusData(Karyawan data);
}