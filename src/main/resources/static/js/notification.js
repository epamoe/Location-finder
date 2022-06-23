
function notification(){

    let dateEntreeLocataire = document.getElementById("dateEntree");
    var tempsActuel = new Date();
    var nom=document.getElementById('nomLocataire');
    var a = document.Numero_cni
    var delai=dateEntreeLocataire-tempsActuel;
    dateEntreeLocataire=dateEntreeLocataire.innerText;

    if (tempsActuel === dateEntreeLocataire){

         return alert("jour de payement arrivé");

    }else if (tempsActuel <= dateEntreeLocataire) {

        return alert("retard de payement de " +delai);

    }else if(tempsActuel >= dateEntreeLocataire){

        return alert("date de payement dans " +delai);

    } else{

        return alert("une erreur c'est produite pendant le calcul");

    }

}