USE [master]
GO
/****** Object:  Database [manage]    Script Date: 10/21/2018 10:28:32 AM ******/
CREATE DATABASE [manage]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'manage', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\manage.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'manage_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\manage_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [manage] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [manage].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [manage] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [manage] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [manage] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [manage] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [manage] SET ARITHABORT OFF 
GO
ALTER DATABASE [manage] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [manage] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [manage] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [manage] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [manage] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [manage] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [manage] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [manage] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [manage] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [manage] SET  DISABLE_BROKER 
GO
ALTER DATABASE [manage] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [manage] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [manage] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [manage] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [manage] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [manage] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [manage] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [manage] SET RECOVERY FULL 
GO
ALTER DATABASE [manage] SET  MULTI_USER 
GO
ALTER DATABASE [manage] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [manage] SET DB_CHAINING OFF 
GO
ALTER DATABASE [manage] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [manage] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [manage] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'manage', N'ON'
GO
ALTER DATABASE [manage] SET QUERY_STORE = OFF
GO
USE [manage]
GO
/****** Object:  Table [dbo].[item]    Script Date: 10/21/2018 10:28:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[item](
	[id] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
	[code] [varchar](50) NULL,
	[provider] [varchar](50) NULL,
	[quantity] [int] NULL,
	[price_import] [int] NULL,
	[price_export] [int] NULL,
	[note] [varchar](50) NULL,
	[unit_type] [varchar](50) NULL,
 CONSTRAINT [PK_item] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[person]    Script Date: 10/21/2018 10:28:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[person](
	[id] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
	[address] [varchar](50) NULL,
	[total] [int] NULL,
	[phone] [varchar](50) NULL,
	[created_at] [varchar](50) NULL,
	[note] [varchar](50) NULL,
	[type] [varchar](50) NULL,
 CONSTRAINT [PK_person] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[storage]    Script Date: 10/21/2018 10:28:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[storage](
	[id] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
	[code] [varchar](50) NULL,
	[total] [int] NULL,
	[person] [varchar](50) NULL,
	[created_at] [varchar](50) NULL,
	[note] [varchar](50) NULL,
	[type] [varchar](50) NULL,
	[quantity] [int] NULL,
	[price] [int] NULL,
	[type_data] [nchar](10) NULL,
 CONSTRAINT [PK_storage] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [manage] SET  READ_WRITE 
GO
