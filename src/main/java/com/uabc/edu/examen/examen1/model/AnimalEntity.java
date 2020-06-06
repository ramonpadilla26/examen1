package com.uabc.edu.examen.examen1.model;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Table(name = "TBL_ANIMALES")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "tipoanimal",nullable = false)
    private String tipoanimal;

    @Column(name = "color",nullable = false)
    private String color;

    @Column(name = "raza",nullable = false)
    private String raza;

    @Column(name = "tipopelo",nullable = false)
    private String tipopelo;

    @Column(name = "fechanac",nullable = false)
    private String fechanac;

    @Column(name = "vacunas",nullable = false)
    private boolean vacunas;

    @Column(name = "estadoadopcion",nullable = false)
    private boolean estadoadopcion;

    @Column(name = "nombredueño",nullable = false)
    private String nombredueño;

    @Column(name = "img", nullable = true)
    private byte[] img;

    @Column(name = "str", nullable = true)
    private String str;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoanimal() {
        return tipoanimal;
    }

    public void setTipoanimal(String tipoanimal) {
        this.tipoanimal = tipoanimal;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getTipopelo() {
        return tipopelo;
    }

    public void setTipopelo(String tipopelo) {
        this.tipopelo = tipopelo;
    }

    public String getFechaNac() {
        return fechanac;
    }

    public void setFechaNac(String fechanac) {
        this.fechanac = fechanac;
    }

    public boolean isVacunas() {
        return vacunas;
    }

    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }

    public boolean isEstadoAdopcion() {
        return estadoadopcion;
    }

    public void setEstadoAdopcion(boolean estadoAdopcion) {
        this.estadoadopcion = estadoAdopcion;
    }

    public String getNombredueño() {
        return nombredueño;
    }

    public void setNombredueño(String nombredueño) {
        this.nombredueño = nombredueño;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    @Override
    public String toString() {
        return "AnimalEntity [id=" + id + ", tipoanimal=" + tipoanimal +
                ", color=" + color + ", raza=" + raza   +  ", tipopelo=" + tipopelo   +
                ", fechanac=" + fechanac   +  ", vacunas=" + vacunas   +  ", estadoadopcion=" + estadoadopcion   +
                ", nombredueño=" + nombredueño   + ", img=" + Arrays.toString(img) + ", str=" + str              + "]";
    }


}
