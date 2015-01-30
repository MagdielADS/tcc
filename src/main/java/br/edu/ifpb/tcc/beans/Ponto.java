/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.tcc.beans;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Ponto {
    private String latitude, longitude;
    
    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Ponto{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
    }
}
