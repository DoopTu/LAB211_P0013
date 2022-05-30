/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class TranscriptList extends ArrayList<Transcript> {

    private List<Transcript> transcript;

    public TranscriptList() {
        super();
    }

    public boolean containStudent(String subId) {
        for (Transcript t : this) {
            if (t.StObj.id.equals(subId)) {
                return true;
            }
        }
        return false;
    }

    public boolean containSubject(String subId) {
        for (Transcript t : this) {
            if (t.SubObj.subID.equals(subId)) {
                return true;
            }
        }
        return false;
    }

    
}
