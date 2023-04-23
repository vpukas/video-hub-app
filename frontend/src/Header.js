import React, { useState } from "react";
import "./Header.css";
import MenuIcon from "@mui/icons-material/Menu";
import SearchIcon from "@mui/icons-material/Search";
import VideoCallIcon from "@mui/icons-material/VideoCall";
import NotificationsIcon from "@mui/icons-material/Notifications";
import { Avatar } from "@mui/material/";
import logo from "./logo.svg";
import { Link } from "react-router-dom";

function Header() {
  const [inputSearch, setInputSearch] = useState("");

  return (
    <div className="header">
      <div className="header__left">
        <MenuIcon style={{ color: "white" }} />
        <Link to="/">
          <img className="header__logo" src={logo} alt="" />
        </Link>
      </div>
      <div className="header__input">
        <input
          type="text"
          placeholder="Search"
          style={{
            flex: 1,
            border: "1px solid #000000",
            padding: "8.3px 20px",
            width: "30vw",
            backgroundColor: "#023047",
            color: "white",
            fontSize: "16px",
          }}
          value={inputSearch}
          onChange={(e) => setInputSearch(e.target.value)}
        />
        <Link to={`/search/${inputSearch}`}>
          <SearchIcon
            className="header__inputButton"
            style={{ color: "#9b9b9b", padding: "4px 10px" }}
          />
        </Link>
      </div>
      <div className="header__right">
        <VideoCallIcon style={{ color: "#000000", marginLeft: "10px" }} />
        <NotificationsIcon style={{ color: "#000000", marginLeft: "20px" }} />
        <Avatar
          style={{ height: "30px", width: "30px", marginLeft: "20px" }}
          className="avatar"
          src="https://lh3.googleusercontent.com/a/AGNmyxZeg5vEGLb--LwVfAwbMBxI1al_vieIPI7TuZhkTg=s96-c-rg-br100https://lh3.googleusercontent.com/a-/AOh14GhFApbsFe2s2E2H0CL1Nr5WjNXrxPRtfsleJopI=s88-c-k-c0x00ffffff-no-rj-mo"
          alt="Valerii Pukas"
        />
      </div>
    </div>
  );
}

export default Header;
