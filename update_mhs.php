<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
		$npm = $_POST['npm'];
		$nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
		
		require_once('dbConnect.php');
		
		$sql = "update tbl_mhs set nama = '$nama', alamat = '$alamat' where npm = '$npm'";
		
		
		if(mysqli_query($con,$sql)){
			echo 'sukses';
		}else{
			echo 'coba lagi';
		}
		
		//closing connection 
		mysqli_close($con);
}

?>