import React from "react";
import "./App.css";
import Header from "./Header";
import Sidebar from "./Sidebar";
import SearchPage from "./SearchPage";
import RecommendedVideos from "./RecommendedVideos";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="app">
      <Router>
        <Header />
        <Routes>
          <Route path="/search/:searchTerm" >
          </Route>
          <Route path="/" element={<div className="app__page">
              <Sidebar />
              <RecommendedVideos />
            </div>}>
          </Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
