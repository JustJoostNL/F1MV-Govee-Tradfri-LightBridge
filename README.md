<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>



<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GNU GPL 3.0 License][license-shield]][license-url]

##### *Thanks to [othneildrew](https://github.com/othneildrew/Best-README-Template) for this amazing README template!*
<!-- PROJECT LOGO -->

<h3 align="center">F1MV Govee and Tradfri Lights Integration</h3>
<div align="center">
  <p align="center">
    Connect your Govee and Tradfri lights to your F1MV
    <br />
    <a href="https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/wiki/First-Time-Configuration"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/issues">Report Bug</a>
    ·
    <a href="https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://i.ibb.co/qsJ7jNY/Screenshot-2022-10-19-194139.png)

This project is a simple bridge between F1MV and Govee and Tradfri lights. It allows you to sync the lights with the current session open in F1MV. This is done by using the Govee Developer API and the Tradfri Gateway. The bridge is written in Java and uses multiple dependencies. This program is designed to run on the computer where F1MV also runs, but you can also run it for example on a little VPS.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![F1MV][f1mv]][f1mv-url]
* [![Java][java]][java-url]
* [![Maven][maven]][maven-url]
* [![Govee][govee]][govee-url]
* [![Tradfri][tradfri]][tradfri-url]
* [![Stijngroenen-libary][tradfri-api-badge]][tradfri-api]
* [![Californium][californium-badge]][californium-url]
* [![Gson][gson-badge]][gson-url]
* [![org.slf4j][org.slf4j-badge]][org.slf4j-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Getting started is very easy. Just follow the steps below. If you have any questions, feel free to contact me on discord

### Prerequisites

You need to have java installed on your computer. You can download it [here](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)

### Installation

Go to the [releases page][releases-url] and download the latest release.
And follow the [wiki page][wikiurl] for the first startup and configuration.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE Instructions -->
## Usage

Please go to the [Wiki][wikiurl] for usage instructions.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Add support for mulitple Govee devices
- [ ] Create a proper installer
<!--  - [ ] Use JavaScript instead of Java -->
<!--    - [ ] Nested Feature -->

See the [open issues][issuesurl]) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the GNU General Public License v3.0. See `LICENSE.md` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Thanks to MultiViewer For F1 for the amazing software!](https://beta.f1mv.com/)


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/koningcool/F1MV-Govee-Tradfri-LightBridge.svg?style=for-the-badge
[contributors-url]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/koningcool/F1MV-Govee-Tradfri-LightBridge.svg?style=for-the-badge
[forks-url]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/network/members
[stars-shield]: https://img.shields.io/github/stars/koningcool/F1MV-Govee-Tradfri-LightBridge.svg?style=for-the-badge
[stars-url]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/stargazers
[issues-shield]: https://img.shields.io/github/issues/koningcool/F1MV-Govee-Tradfri-LightBridge.svg?style=for-the-badge
[issues-url]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/issues
[license-shield]: https://img.shields.io/github/license/koningcool/F1MV-Govee-Tradfri-LightBridge.svg?style=for-the-badge
[license-url]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/blob/main/LICENSE.MD
[product-screenshot]: https://i.ibb.co/qsJ7jNY/Screenshot-2022-10-19-194139.png
[java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[java-url]: https://www.java.com/en/
[github-actions]: https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white
[ide]: https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[Git]: https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white
[maven]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[maven-url]: https://maven.apache.org/
[govee]: https://img.shields.io/badge/Govee-076bfb.svg?style=for-the-badge&logo=govee&logoColor=white
[govee-url]: https://www.govee.com/
[tradfri]: https://img.shields.io/badge/IKEA%20Tradfri-c5c004.svg?style=for-the-badge&logo=ikea&logoColor=white
[tradfri-url]: https://www.ikea.com/nl/en/cat/smart-home-hs001/
[f1mv]: https://img.shields.io/badge/MultiViewer%20For%20F1-fb1e07.svg?style=for-the-badge&logo=f1&logoColor=white
[f1mv-url]: https://beta.f1mv.com
[releases-url]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/releases
[wikiurl]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/wiki/First-Time-Configuration
[issuesurl]: https://github.com/koningcool/F1MV-Govee-Tradfri-LightBridge/issues
[tradfri-api-badge]: https://img.shields.io/badge/Stijngroenen%20Tradfri%20API-green.svg?style=for-the-badge
[tradfri-api]: https://github.com/stijngroenen/tradfri-tradfri-api
[californium-badge]: https://img.shields.io/badge/Californium-purple.svg?style=for-the-badge
[californium-url]: https://www.eclipse.org/californium/
[gson-badge]: https://img.shields.io/badge/Gson-yellow.svg?style=for-the-badge
[gson-url]: https://github.com/google/gson
[org.slf4j-badge]: https://img.shields.io/badge/org.slf4j-blue.svg?style=for-the-badge
[org.slf4j-url]: https://www.slf4j.org/

[github_username]: koningcool
[repo_name]: F1MV-Govee-Tradfri-LightBridge
