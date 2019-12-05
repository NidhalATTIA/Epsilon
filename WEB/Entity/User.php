<?php


namespace TicketBundle\Entity;



	use Doctrine\Common\Collections\Collection;
    use FOS\UserBundle\Model\GroupInterface;
    use FOS\UserBundle\Model\User as BaseUser;
	use Doctrine\ORM\Mapping as ORM;

	/**
	 * @ORM\Entity
	 * @ORM\Table(name="fos_user")
 */
	class User extends BaseUser
	{
        /**
         * @return string
         */
        public function getUsername()
        {
            return $this->username;
        }

        /**
         * @param string $username
         */
        public function setUsername($username)
        {
            $this->username = $username;
        }

        /**
         * @return string
         */
        public function getUsernameCanonical()
        {
            return $this->usernameCanonical;
        }

        /**
         * @param string $usernameCanonical
         */
        public function setUsernameCanonical($usernameCanonical)
        {
            $this->usernameCanonical = $usernameCanonical;
        }

        /**
         * @return string
         */
        public function getEmail()
        {
            return $this->email;
        }

        /**
         * @param string $email
         */
        public function setEmail($email)
        {
            $this->email = $email;
        }

        /**
         * @return string
         */
        public function getEmailCanonical()
        {
            return $this->emailCanonical;
        }

        /**
         * @param string $emailCanonical
         */
        public function setEmailCanonical($emailCanonical)
        {
            $this->emailCanonical = $emailCanonical;
        }

        /**
         * @return bool
         */
        public function isEnabled()
        {
            return $this->enabled;
        }

        /**
         * @param bool $enabled
         */
        public function setEnabled($enabled)
        {
            $this->enabled = $enabled;
        }

        /**
         * @return string
         */
        public function getSalt()
        {
            return $this->salt;
        }

        /**
         * @param string $salt
         */
        public function setSalt($salt)
        {
            $this->salt = $salt;
        }

        /**
         * @return string
         */
        public function getPassword()
        {
            return $this->password;
        }

        /**
         * @param string $password
         */
        public function setPassword($password)
        {
            $this->password = $password;
        }

        /**
         * @return string
         */
        public function getPlainPassword()
        {
            return $this->plainPassword;
        }

        /**
         * @param string $plainPassword
         */
        public function setPlainPassword($plainPassword)
        {
            $this->plainPassword = $plainPassword;
        }

        /**
         * @return \DateTime|null
         */
        public function getLastLogin()
        {
            return $this->lastLogin;
        }

        /**
         * @param \DateTime|null $lastLogin
         */
        public function setLastLogin($lastLogin)
        {
            $this->lastLogin = $lastLogin;
        }

        /**
         * @return string|null
         */
        public function getConfirmationToken()
        {
            return $this->confirmationToken;
        }

        /**
         * @param string|null $confirmationToken
         */
        public function setConfirmationToken($confirmationToken)
        {
            $this->confirmationToken = $confirmationToken;
        }

        /**
         * @return \DateTime|null
         */
        public function getPasswordRequestedAt()
        {
            return $this->passwordRequestedAt;
        }

        /**
         * @param \DateTime|null $passwordRequestedAt
         */
        public function setPasswordRequestedAt($passwordRequestedAt)
        {
            $this->passwordRequestedAt = $passwordRequestedAt;
        }

        /**
         * @return Collection|GroupInterface[]
         */
        public function getGroups()
        {
            return $this->groups;
        }

        /**
         * @param Collection|GroupInterface[] $groups
         */
        public function setGroups($groups)
        {
            $this->groups = $groups;
        }

        /**
         * @return mixed
         */
        public function getId()
        {
            return $this->id;
        }

        /**
         * @param mixed $id
         */
        public function setId($id)
        {
            $this->id = $id;
        }

        /**
         * @return array
         */
        public function getRoles()
        {
            return $this->roles;
        }

        /**
         * @param array $roles
         */
        public function setRoles($roles)
        {
            $this->roles = $roles;
        }
   	    /**
   	     * @ORM\Id
   	     * @ORM\Column(type="integer")
   	     * @ORM\GeneratedValue(strategy="AUTO")
   	     */
	    protected $id;

	    public function __construct()
    {
            parent::__construct();
	        // your own logic
	    }
	}
