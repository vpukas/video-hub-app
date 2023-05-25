import React, { useState } from 'react';
import "./App.css";
import Header from "./Header";
import Sidebar from "./Sidebar";
import SearchPage from "./SearchPage";
import RecommendedVideos from "./RecommendedVideos";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  const [showSidebar, setShowSidebar] = useState(false);

  const toggleSidebar = () => {
    setShowSidebar(!showSidebar);
  };

  return (
    <div className="app">

      <Router>

        <Header onMenuClick={toggleSidebar}/>
        <Routes>
          <Route path="/search/:searchTerm" >
          </Route>
          <Route path="/" element={<><Sidebar show={showSidebar} /><RecommendedVideos /></>

          }>
          </Route>
        </Routes>
      </Router>

    </div>
  );
}

export default App;
