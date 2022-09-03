import React from 'react';
import './App.css';
import { Link,Outlet } from 'react-router-dom';
// import { Link,Outlet,BrowserRouter,Route,Routes } from 'react-router-dom';

const Blogs = () => {
	return <h1>Blog Articles</h1>;
  };

const Home = () => {
	return <h1>Articles</h1>;
  };
  

const Homepage = () => {
	return (
		<>
		  <nav>
			<ul>
			  <li>
				<Link to="/home	">Home</Link>
			  </li>
			  <li>
				<Link to="/blogs">Blogs</Link>
			  </li>
			  <li>
				<Link to="/contact">Contact</Link>
			  </li>
			</ul>
		  </nav>
	
		  <Outlet />
		</>
	  )
	};
export {Homepage,Blogs,Home}; //new
// export default App;