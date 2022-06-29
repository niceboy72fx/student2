import React from "react";
import { AppBar ,Toolbar,Typography } from "@mui/material";
import SchoolIcon from '@mui/icons-material/School'
import './HeaderStyle.css';


const Header = () => {
	return (
		<React.Fragment>
			<AppBar sx={{background:"whitesmoke", color:"blue"}}>
				<Toolbar >
			        <SchoolIcon />
				
				<Typography >
					TuyenSinh24h
					
				</Typography>
			         <div className="navbar">
					   <a href="/">Home</a>
					   <a href="/search">Search</a>
				 </div>
				</Toolbar>
			</AppBar>
		</React.Fragment>
	);
}

export default Header;