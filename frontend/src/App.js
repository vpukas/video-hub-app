import React, { useState, useEffect } from 'react';
import "./App.css";
import Header from "./Header";
import Sidebar from "./Sidebar";
import SearchPage from "./SearchPage";
import RecommendedVideos from "./RecommendedVideos";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./Login";
import VideoPage from "./VideoPage";
import ChannelHomepage from "./ChannelHomepage";
import VideoUpload from "./VideoUpload";
import VideoHistory from "./VideoHistory";
import Register from "./Register";
import SubscribedChannels from "./SubscribedChannels";
import UserVideos from "./UserVideos";

function App() {
  const [showSidebar, setShowSidebar] = useState(false);
  const [isLoginPage, setIsLoginPage] = useState(false);
  const [isRegPage, setIsRegPage] = useState(false);

  const toggleSidebar = () => {
    setShowSidebar(!showSidebar);
  };

  useEffect(() => {
    setIsLoginPage(window.location.pathname === '/login');
  }, []);

  useEffect(() => {
    setIsRegPage(window.location.pathname === '/register');
  }, []);

  return (
      <div className="app">
        <Router>
          {!isLoginPage && !isRegPage && <Header onMenuClick={toggleSidebar} />}
          <Routes>
            <Route path="/channel/:channelId" element={<><Sidebar show={showSidebar} /><ChannelHomepage /></>} />
            <Route path="/video/:videoId" element={<><Sidebar show={showSidebar} /><VideoPage /></>} />
            <Route path="/login" element={<Login />} />
            <Route path="/upload" element={<><Sidebar show={showSidebar} /><VideoUpload /></>} />
            <Route path="/" element={<><Sidebar show={showSidebar} /><RecommendedVideos /></>} />
            <Route path="/history" element={<><Sidebar show={{showSidebar}}/> <VideoHistory/></>} />
            <Route path="/register" element={<Register />} />
            <Route path="/subscriptions" element={<><Sidebar show={{showSidebar}}/> <SubscribedChannels/></>} />
            <Route path="/channel" element={<><Sidebar show={{showSidebar}}/> <UserVideos/></>} />
          </Routes>
        </Router>
      </div>
  );
}

export default App;
