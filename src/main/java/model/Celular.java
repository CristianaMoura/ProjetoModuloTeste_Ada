package model;

import enums.TipoReparo;

/**
 * @author CrisMoura on 17/02/2023
 */
public class Celular {
    String marca;
    String modelo;
    Integer id;


    public Celular(String marca, String modelo, Integer id) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
