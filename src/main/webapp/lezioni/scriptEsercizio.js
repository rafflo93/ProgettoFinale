//PER CAMBIARE COLORE AL TESTO
let cont = 0;
const contenitore = document.getElementById("contenitore");
const schermo = document.getElementById("schermo");
let lunghezzaTesto = schermo.textContent.length;
let testoDaCopiare = schermo.textContent;

let giusto = 0;
let errori = 0;
schermo.textContent = "";
const prendiSpazio = document.getElementById("spazioNascosto");

for (let i = 0; i < lunghezzaTesto; i++) {

    const contenutoSchermo = document.createElement('span');
    contenutoSchermo.style = "color: gray;";
    if (testoDaCopiare[i] != "\n") {
        contenutoSchermo.textContent = testoDaCopiare[i];
    } else {
        console.log("Trovato carattere n")
        contenutoSchermo.textContent = prendiSpazio.textContent;
    }
    contenutoSchermo.setAttribute('id', i);
    schermo.appendChild(contenutoSchermo);
}



//PER CAMBIARE COLORE ALLA TASTIERA
//Creo due funzioni per "illuminare" il tasto.
//Una sarà richiamata quando viene premuto, l'altra quando viene rilasciato.
//Come parametro passo la lettera da premere

function premiTasto(lettera) {
    const key = document.getElementById(lettera);
    key.style.backgroundColor = "#ff581c";
}

function lasciaTasto(lettera) {
    const key = document.getElementById(lettera);
    key.style.backgroundColor = "";
}

//Le due funzioni sono richiamate in questi switch, che danno un valore al parametro lettera.

let parteTempo = 0;
document.addEventListener("keypress", function premi(event) {
    tasto = event.key;
    cambiaColore();

    //per far partire il cronometro
    parteTempo++;
    if (parteTempo == 1) {

        setInterval(contaSecondi, 1000);
        riprova.style.opacity = "100%";
    }



    if (cont == lunghezzaTesto && giusto == lunghezzaTesto) {

        let paroleMin = (lunghezzaTesto / 5 / secondi) * 60;
        if (window.confirm("Esercizio terminato!\nErrori: " + errori + "\nTempo impiegato: " + secondi + " secondi\nParole al minuto: " + Math.round(paroleMin))) {

            history.back();
        }
        else {
            window.location.replace("/lezioni/esercizi");
        }
    }


    switch (tasto.toLowerCase()) {
        //prima fila
        case "\\":
            premiTasto("slash");
            break;
        case "|":
            premiTasto("slash");
            break;
        case "1":
            premiTasto("uno");
            break;
        case "!":
            premiTasto("uno");
            break;
        case "2":
            premiTasto("due");
            break;
        case "\"":
            premiTasto("due");
            break;
        case "3":
            premiTasto("tre");
            break;
        case "4":
            premiTasto("quattro");
            break;
        case "5":
            premiTasto("cinque");
            break;
        case "%":
            premiTasto("cinque");
            break;
        case "6":
            premiTasto("sei");
            break;
        case "&":
            premiTasto("sei");
            break;
        case "7":
            premiTasto("sette");
            break;
        case "\/":
            premiTasto("sette");
            break;
        case "8":
            premiTasto("otto");
            break;
        case "(":
            premiTasto("otto");
            break;
        case "9":
            premiTasto("nove");
            break;
        case ")":
            premiTasto("nove");
            break;
        case "0":
            premiTasto("zero");
            break;
        case "=":
            premiTasto("zero");
            break;
        case "'":
            premiTasto("interr");
            break;
        case "?":
            premiTasto("interr");
            break;

        //seconda fila
        case "q":
            premiTasto("q");
            break;
        case "w":
            premiTasto("w");
            break;
        case "e":
            premiTasto("e");
            break;
        case "r":
            premiTasto("r");
            break;
        case "t":
            premiTasto("t");
            break;
        case "y":
            premiTasto("y");
            break;
        case "u":
            premiTasto("u");
            break;
        case "i":
            premiTasto("i");
            break;
        case "o":
            premiTasto("o");
            break;
        case "p":
            premiTasto("p");
            break;
        case "è":
            premiTasto("eAcc");
            break;
        case "[":
            premiTasto("eAcc");
            break;
        case "{":
            premiTasto("eAcc");
            break;
        case "+":
            premiTasto("piu");
            break;
        case "]":
            premiTasto("piu");
            break;
        case "}":
            premiTasto("piu");
            break;

        //terza fila
        case "a":
            premiTasto("a");
            break;
        case "s":
            premiTasto("s");
            break;
        case "d":
            premiTasto("d");
            break;
        case "f":
            premiTasto("f");
            break;
        case "g":
            premiTasto("g");
            break;
        case "h":
            premiTasto("h");
            break;
        case "j":
            premiTasto("j");
            break;
        case "k":
            premiTasto("k");
            break;
        case "l":
            premiTasto("l");
            break;
        case "ò":
            premiTasto("oAcc");
            break;
        case "@":
            premiTasto("oAcc");
            break;
        case "enter":
            tasto[0].toUpperCase();
            premiTasto("enter");
            break;

        //quarta fila
        case "z":
            premiTasto("z");
            break;
        case "x":
            premiTasto("x");
            break;
        case "c":
            premiTasto("c");
            break;
        case "v":
            premiTasto("v");
            break;
        case "b":
            premiTasto("b");
            break;
        case "n":
            premiTasto("n");
            break;
        case "m":
            premiTasto("m");
            break;
        case ",":
            premiTasto("virg");
            break;
        case ";":
            premiTasto("virg");
            break;
        case ".":
            premiTasto("punto");
            break;
        case ":":
            premiTasto("punto");
            break;
        case "-":
            premiTasto("tratt");
            break;
        case "_":
            premiTasto("tratt");
            break;

        //quinta fila
        case "Control":
            premiTasto("ctrl");
            break;
        case " ":
            premiTasto("spazio");
            break;
        case "<":
            premiTasto("unc");
            break;
        case ">":
            premiTasto("unc");
            break;
    }
})

document.addEventListener("keyup", (event) => {
    tasto = event.key;
    switch (tasto.toLowerCase()) {
        //prima fila
        case "\\":
            lasciaTasto("slash");
            break;
        case "|":
            lasciaTasto("slash");
            break;
        case "1":
            lasciaTasto("uno");
            break;
        case "!":
            lasciaTasto("uno");
            break;
        case "2":
            lasciaTasto("due");
            break;
        case "\"":
            lasciaTasto("due");
            break;
        case "3":
            lasciaTasto("tre");
            break;
        case "4":
            lasciaTasto("quattro");
            break;
        case "5":
            lasciaTasto("cinque");
            break;
        case "%":
            lasciaTasto("cinque");
            break;
        case "6":
            lasciaTasto("sei");
            break;
        case "&":
            lasciaTasto("sei");
            break;
        case "7":
            lasciaTasto("sette");
            break;
        case "\/":
            lasciaTasto("sette");
            break;
        case "8":
            lasciaTasto("otto");
            break;
        case "(":
            lasciaTasto("otto");
            break;
        case "9":
            lasciaTasto("nove");
            break;
        case ")":
            lasciaTasto("nove");
            break;
        case "0":
            lasciaTasto("zero");
            break;
        case "=":
            lasciaTasto("zero");
            break;
        case "'":
            lasciaTasto("interr");
            break;
        case "?":
            lasciaTasto("interr");
            break;
        case "backspace":
            tasto[0].toUpperCase();
            lasciaTasto("cancella");
            break;

        //seconda fila
        case "q":
            lasciaTasto("q");
            break;
        case "w":
            lasciaTasto("w");
            break;
        case "e":
            lasciaTasto("e");
            break;
        case "r":
            lasciaTasto("r");
            break;
        case "t":
            lasciaTasto("t");
            break;
        case "y":
            lasciaTasto("y");
            break;
        case "u":
            lasciaTasto("u");
            break;
        case "i":
            lasciaTasto("i");
            break;
        case "o":
            lasciaTasto("o");
            break;
        case "p":
            lasciaTasto("p");
            break;
        case "è":
            lasciaTasto("eAcc");
            break;
        case "[":
            lasciaTasto("eAcc");
            break;
        case "{":
            lasciaTasto("eAcc");
            break;
        case "+":
            lasciaTasto("piu");
            break;
        case "]":
            lasciaTasto("piu");
            break;
        case "}":
            lasciaTasto("piu");
            break;

        //terza fila
        case "a":
            lasciaTasto("a");
            break;
        case "s":
            lasciaTasto("s");
            break;
        case "d":
            lasciaTasto("d");
            break;
        case "f":
            lasciaTasto("f");
            break;
        case "g":
            lasciaTasto("g");
            break;
        case "h":
            lasciaTasto("h");
            break;
        case "j":
            lasciaTasto("j");
            break;
        case "k":
            lasciaTasto("k");
            break;
        case "l":
            lasciaTasto("l");
            break;
        case "ò":
            lasciaTasto("oAcc");
            break;
        case "@":
            lasciaTasto("oAcc");
            break;
        case "enter":
            tasto[0].toUpperCase();
            lasciaTasto("enter");
            break;

        //quarta fila
        case "z":
            lasciaTasto("z");
            break;
        case "x":
            lasciaTasto("x");
            break;
        case "c":
            lasciaTasto("c");
            break;
        case "v":
            lasciaTasto("v");
            break;
        case "b":
            lasciaTasto("b");
            break;
        case "n":
            lasciaTasto("n");
            break;
        case "m":
            lasciaTasto("m");
            break;
        case ",":
            lasciaTasto("virg");
            break;
        case ";":
            lasciaTasto("virg");
            break;
        case ".":
            lasciaTasto("punto");
            break;
        case ":":
            lasciaTasto("punto");
            break;
        case "-":
            lasciaTasto("tratt");
            break;
        case "_":
            lasciaTasto("tratt");
            break;

        //quinta fila
        case " ":
            lasciaTasto("spazio");
            break;
        case "<":
            lasciaTasto("unc");
            break;
        case ">":
            lasciaTasto("unc");
            break;
    }
})
let riprendi = true;

document.addEventListener("keydown", (event) => {
    tastoCanc = event.key;

    if (tastoCanc === "Backspace") {
        const letteraTesto = document.getElementById(cont);
        letteraTesto.style = "";
        premiTasto("cancella");
        riprendi = true;
    }
})

function cambiaColore() {

    const letteraTesto = document.getElementById(cont);

    if (tasto === testoDaCopiare[cont]) {
        if (riprendi == true) {
            letteraTesto.style.color = "green";
            cont++;
            giusto++;
        }
    } else {
        letteraTesto.style.color = "red";
        errori++;
        errori2.textContent = "Errori: " + errori;
        riprendi = false;
    }
}

//FUNZIONE PER CONTARE
let secondi = 0;
//var el = document.getElementById('seconds-counter');

const crono = document.getElementById("cronometro");
const scriviSec = document.createElement("p");
scriviSec.textContent = "00:00";

function contaSecondi() {
    secondi += 1;
    contaS();
}

crono.appendChild(scriviSec);

//cronometro visibile
function contaS() {
    let minuti = 0; // ad ogni minuto si riavvia

    if (minuti == 0 && secondi < 10) {
        scriviSec.textContent = "00:" + minuti + secondi;
    }
    else if (minuti == 0 && secondi < 60) {
        scriviSec.textContent = "00:" + secondi;
    }
    else {
        minuti++;
        secondi = 0;
        if (secondi < 10) {
            scriviSec.textContent = "0" + minuti + ":0" + secondi;
        } else scriviSec.textContent = "0" + minuti + ":" + secondi;
    }
}

const img = document.getElementById("img");
img.onclick = () => {
    window.open("../", "_self");
}

const riprova = document.getElementById("riprova");
riprova.onclick = () => {
    window.location.reload();
}

const errori2 = document.getElementById("errori");