import React from "react";
import './DropFile.css';
import { Button } from "@mui/material";
import axios from "axios";
import { Component } from "react";
import { useNavigate } from 'react-router-dom';


class Upfile extends Component {
	constructor(){
		super()
		this.state = {
			file : null
		}
		
	}

	handleUpload(e) {
		console.log(this.state);
		if(this.state.file ){
			const formData = new FormData();
			formData.append("student", this.state.file);
			axios.post("http://localhost:8080/student/import/", formData, {
				headers : {
					"content-type" : "multipart/form-data"
				}
			}).then(result => console.log(result.data)).catch(err => console.log(err))
		}
	}

	

	 onChange =(e)=>{
		let file = e.target.files[0];
		this.setState({file:file});
		// let reader = new FileReader();
		// reader.readAsDataURL(file[0]);
		// reader.onload=(e)=> {
		// 	console.warn("xslx",e.target.result)
		// }
	}	
	render (){
         
	 return (
		<div className="DropFile">
			<div className="DropFileInput_lable">
				
				<p>Click to import</p>
				<h6>recommend file .xlsx</h6>
				<br />
				<Button size="large" variant="contained" onClick={this.handleUpload.bind(this)} >UpLoad</Button>
				<h6 className="error"></h6>
			</div>
			<input type="file" value="" onChange={this.onChange.bind(this)} / >
		</div>
	    );
	}


}
 






export default Upfile;