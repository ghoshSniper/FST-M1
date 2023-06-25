# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webdriver import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/ajax")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Initialize the wait object
    wait = WebDriverWait(driver, 10)

    # Find the "Change Content" button and click it
    driver.find_element(By.CSS_SELECTOR, "button.violet").click()
    # Wait for the text "HELLO!" to appear
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    hello_text = driver.find_element(By.TAG_NAME, "h1").text
    # Print the text
    print(hello_text)

    # Wait for "I'm late!" to appear
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    late_text = driver.find_element(By.TAG_NAME, "h3").text
    # Print the text
    print(late_text)