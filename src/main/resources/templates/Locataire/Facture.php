<?php
/*****************************Connexion à la base de données ********************************/
	function valider()
	{
		try
		{
			$pdo_options[PDO::ATTR_ERRMODE] = PDO::ERRMODE_EXCEPTION;
			$bdd = new PDO('mysql:host=localhost;dbname=tp_bd', 'root', '', $pdo_options);
			//echo "Connexion reussi";
			$bdd->query("SET NAMES UTF8");
			return $bdd;
		}
		catch (Exception $e)
		{
				die('Erreur : ' . $e->getMessage());
		}

	}
/**************************************Checking du login et du mot de passe **********************************************/
	/*function passwordLogin($login,$password)
	{
		$bdd = connecter();
		$req = $bdd->prepare('SELECT * FROM enseignant WHERE login = ? AND passwd = PASSWORD(?)');
		$p = $req->execute(array($login,$password));
		$param = $req->fetch();
		if(!$param)
		{
			$chaine = 'Compte inexistant';
		}
		else
		{
		   $enseignant_obj = getTuple("enseignant","login", $param['login']);
		   $enseignant = $enseignant_obj->fetch();

		   $chaine = 'Bonjour '.$enseignant['nom'];
		}
	    return $chaine;
	}
	*/
/***********************Affichage des étudiants*****************************/
	function afficheFacture()
	{
		$bdd = connecter();
		$req = $bdd->prepare('SELECT * FROM Facture ORDER BY nom DESC');
		$p = $req->execute();
		$row = $req->fetch();
		$chaine="";
   		if($row) {
			while($row) {
        		 //ecriture des tags de retour
			 $chaine=$chaine."<tr>\n";
			 $chaine=$chaine."<td>".$row['matricule']."</td>";
			 $chaine=$chaine."<td>".$row['nom']."</td>";
			 $chaine=$chaine."<td>".$row['login']."</td>";
			 $chaine=$chaine."\n</tr>\n";
			 $row = $req->fetch();
		       }

		} else {
			$chaine="<tr><td>pas d'entrée</td></tr>";
		}
		return $chaine;
	}
/*******************************Obtention d'un ensemble de tuple*********************************/
	function getTuple($tab,$param,$val)
	{
		$bdd = connecter();
		$req = $bdd->prepare('SELECT * FROM '. $tab.' WHERE '.$param. '= ?');

		$req->execute(array($val));

		return $req;
	}

/******************************Insertion des étudiants dans la base de données *********************/
	function inserEnseignant($login, $password, $grade, $UE)
	{
		try{
			$bdd = connecter();
			$req = $bdd->prepare('INSERT INTO enseignant (login, password, grade, UE) values(?,?,?,PASSWORD(?))');
			$req->execute(array($login, $password, $grade, $UE));
			return true;
		}
		catch(PDOException $e){
			echo $e->getMessage();
			return false;
		}
	}
?>
