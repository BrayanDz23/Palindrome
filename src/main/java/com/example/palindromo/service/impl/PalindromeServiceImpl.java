package com.example.palindromo.service.impl;

import com.example.palindromo.service.PalindromeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PalindromeServiceImpl implements PalindromeService {
    @Override
    public HashMap<String, String> getPalindrome(String cadena) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("palindrome", buildPalindrome(cadena));
        return hashMap;
    }

    public static void iterateCadena(String cadena, int izquierda, int derecha, ArrayList<String> subcadenas) {
        while (izquierda >= 0 && derecha < cadena.length() && cadena.charAt(izquierda) == cadena.charAt(derecha)) {
            subcadenas.add(cadena.substring(izquierda, derecha + 1));
            izquierda--;
            derecha++;
        }
    }


    public String buildPalindrome(String cadena) {
        if (cadena == null) {
            return "La cadena es requerida";
        }
        ArrayList<String> subcadenas = new ArrayList<>();

        for (int i = 0; i < cadena.length(); i++) {
            iterateCadena(cadena, i, i, subcadenas);
            iterateCadena(cadena, i, i + 1, subcadenas);
        }

        int mayor = 0;
        int indice = 0;

        for (int i = 0; i < subcadenas.size(); i++) {
            if (i == 0) {
                mayor = subcadenas.get(i).length();
                indice = i;
            } else if (subcadenas.get(i).length() > mayor) {
                mayor = subcadenas.get(i).length();
                indice = i;
            }
        }
        if (cadena.length() > 1 && mayor == 1) {
            return "La cadena ingresada no tiene subcadenas palindromes";
        } else {
            return subcadenas.get(indice);
        }
    }
}
