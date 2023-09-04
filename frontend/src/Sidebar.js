import React, {useEffect, useState} from "react";
import "./Sidebar.css";
import SidebarRow from "./SidebarRow";
import HomeIcon from "@mui/icons-material/Home";
import SubscriptionsIcon from "@mui/icons-material/Subscriptions";
import VideoLibraryIcon from "@mui/icons-material/VideoLibrary";
import HistoryIcon from "@mui/icons-material/History";
import OndemandVideoIcon from "@mui/icons-material/OndemandVideo";
import ThumbUpAltOutlinedIcon from "@mui/icons-material/ThumbUpAltOutlined";
import {Link} from "react-router-dom";
import axios from "axios";
import {Avatar} from "@mui/material/";
import './VideoCard.css';

function Sidebar(props) {
  const { show } = props;

  return (
    <div className="sidebar" style={{ transform: show ? 'translateX(0)': 'translateX(-100%)' }}>
     <Link to="/" ><SidebarRow title="Home" Icon={HomeIcon} /></Link>
      <Link to="/subscriptions"><SidebarRow title="Subscription" Icon={SubscriptionsIcon} /></Link>
      <SidebarRow title="History" Icon={HistoryIcon} />
        <Link to="/channel"> <SidebarRow title="Your Videos" Icon={OndemandVideoIcon} /></Link>
      <SidebarRow title="Liked Videos" Icon={ThumbUpAltOutlinedIcon} />
    </div>
  );
}
export default Sidebar;
