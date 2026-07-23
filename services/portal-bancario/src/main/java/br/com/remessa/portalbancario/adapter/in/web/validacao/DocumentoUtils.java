package br.com.remessa.portalbancario.adapter.in.web.validacao;

public final class DocumentoUtils {

    private DocumentoUtils() {
    }

    public static String somenteDigitos(String valor) {
        return valor == null ? null : valor.replaceAll("\\D", "");
    }

    public static boolean isCpf(String documento) {
        String numero = somenteDigitos(documento);
        return numero != null && numero.length() == 11;
    }

    public static boolean isCnpj(String documento) {
        String numero = somenteDigitos(documento);
        return numero != null && numero.length() == 14;
    }

    public static boolean isCpfValido(String documento) {
        String cpf = somenteDigitos(documento);

        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }

        int resto = 11 - (soma % 11);
        int digito1 = (resto >= 10) ? 0 : resto;

        if (digito1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }

        resto = 11 - (soma % 11);
        int digito2 = (resto >= 10) ? 0 : resto;

        return digito2 == (cpf.charAt(10) - '0');
    }

    public static boolean isCnpjValido(String documento) {
        String cnpj = somenteDigitos(documento);

        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += (cnpj.charAt(i) - '0') * peso1[i];
        }

        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        if (digito1 != (cnpj.charAt(12) - '0')) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += (cnpj.charAt(i) - '0') * peso2[i];
        }

        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return digito2 == (cnpj.charAt(13) - '0');
    }

    public static boolean isDocumentoValido(String documento) {
        String numero = somenteDigitos(documento);

        if (numero == null) {
            return false;
        }

        if (numero.length() == 11) {
            return isCpfValido(numero);
        }

        if (numero.length() == 14) {
            return isCnpjValido(numero);
        }

        return false;
    }
}