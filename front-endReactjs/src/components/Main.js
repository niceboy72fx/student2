import React, { Component } from "react";
import './Style.css';
import { AppBar ,Toolbar,Typography } from "@mui/material";
import DropFile from './DropFileInput'
import Img from "./icon/Upload.png";
import axios from 'axios';




const Main = () => {
	return (
		<div className="box">
                        <h2 className="header">
				<img src={Img} alt="" ></img>
				<DropFile />
			</h2>
		
		</div>
	);
}
	

export default Main;