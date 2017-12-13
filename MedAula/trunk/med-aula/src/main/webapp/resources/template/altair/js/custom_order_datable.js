jQuery.extend( jQuery.fn.dataTableExt.oSort, {
    "portugues-pre": function ( data ) {
        var a = 'a';
        var e = 'e';
        var i = 'i';
        var o = 'o';
        var u = 'u';
        var c = 'c';
        var special_letters = {
            "Á": a, "á": a, "Ã": a, "ã": a, "À": a, "à": a,
            "É": e, "é": e, "Ê": e, "ê": e,
            "Í": i, "í": i, "Î": i, "î": i,
            "Ó": o, "ó": o, "Õ": o, "õ": o, "Ô": o, "ô": o,
            "Ú": u, "ú": u, "Ü": u, "ü": u,
            "ç": c, "Ç": c
        };
        for (var val in special_letters)
           data = data.split(val).join(special_letters[val]).toLowerCase();
        return data;
    },
    "portugues-asc": function ( a, b ) {
        return ((a < b) ? -1 : ((a > b) ? 1 : 0));
    },
    "portugues-desc": function ( a, b ) {
        return ((a < b) ? 1 : ((a > b) ? -1 : 0));
    }
} );